package com.epam.enums;

/**
 * Declares locators and expected text for every element in the list
 */
public enum OperativeSystems {
    DEBIAN("free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license", "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)"),
    UBUNTU("paid-ubuntu-pro", "Paid: Ubuntu Pro"),
    WINDOWS("paid-windows-server-2012-r2-windows-server-2016-windows-server-2019-windows-server-2004-20h2", "Paid: Windows Server 2012 R2, Windows Server 2016, Windows Server 2019, Windows Server (2004, 20H2)"),
    RED_HAT_LINUX("paid-red-hat-enterprise-linux", "Paid: Red Hat Enterprise Linux"),
    LINUX_SAP("paid-red-hat-enterprise-linux-for-sap-with-ha-and-update-services", "Paid: Red Hat Enterprise Linux for SAP with HA and Update Services"),
    SLES("paid-sles", "Paid: SLES"),
    SLES_12("paid-sles-12-for-sap", "Paid: SLES 12 for SAP"),
    SLES_15("paid-sles-15-for-sap", "Paid: SLES 15 for SAP"),
    SQL_STANDARD("paid-sql-server-standard-2012-2014-2016-2017-2019", "Paid: SQL Server Standard (2012, 2014, 2016, 2017, 2019)"),
    SQL_WEB("paid-sql-server-web-2012-2014-2016-2017-2019", "Paid: SQL Server Web (2012, 2014, 2016, 2017, 2019)"),
    ENTERPRISE("paid-sql-server-enterprise-2012-2014-2016-2017-2019", "Paid: SQL Server Enterprise (2012, 2014, 2016, 2017, 2019)");

    private String osLocator;
    private String osName;
    private OperativeSystems(String osLocator, String osName) {
        this.osLocator = osLocator;
        this.osName = osName;
    }

    public String getOsLocator() {
        return osLocator;
    }

    public String getOsName() {
        return osName;
    }


}

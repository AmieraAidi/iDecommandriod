package my.com.tm.idecomm;

/**
 * Created by user on 29/11/2017.
 */

public class Config {

    //PSTN SITES
    public static final String URL_PSTN="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn.php";


    //total
    public static final String TAG_JSON_PSTN = "listtotalstatesite";
    public static final String TAG_SITE="STATE";
    public static final String TAG_TOTAL="totalstate";

    //completed
    public static final String TAG_JSON_COMPLETED="listcompletestatesite";
        public static final String TAG_CSITE="STATE";
    public static final String TAG_CTOTAL="count(STATE)";

    //in-progress
    public static final String TAG_JSON_PROGRESS="listinprogressstatesite";
    public static final String TAG_PSITE="STATE";
    public static final String TAG_PTOTAL="count(STATE)";

    //pending
    public static final String TAG_JSON_PENDING="listpendingstatesite";
    public static final String TAG_PENDINGSITE="STATE";
    public static final String TAG_PENDINGTOTAL="count(STATE)";

    //list total sites
    public static final String URL_LIST_SITES="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_list2.php";
    public static final String TAG_JSITE="site";
    public static final String TAG_JWILAYAH="wilayah";
    public static final String TAG_JEX="exchange";
    public static final String TAG_JEXTYPE="exchangetype";
    public static final String TAG_JBUILDING="siteowner";

    //list total complete sites
    public static final String URL_LIST_COMPLETE="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_complete.php";
    public static final String TAG_CSITES="site";
    public static final String TAG_CWILAYAH="migdate";
    public static final String TAG_CEX="exchange";
    public static final String TAG_CEXTYPE="buyer";
    public static final String TAG_CAGING="comdate";

    //list total in-progress sites
    public static final String URL_LIST_PROGRESS="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_inprogress.php";
    public static final String TAG_PSITES="site";
    public static final String TAG_PEX="exchange";
    public static final String TAG_PBUYER="buyer";
    public static final String TAG_PMIG="dismdate";
    public static final String TAG_PAGING="aging";

    //list total remaining sites
    public static final String URL_LIST_REMAINING="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_remaining.php";
    public static final String TAG_RSITES="site";
    public static final String TAG_ROWNER="exchange";
    public static final String TAG_RBUYER="siteown";
    public static final String TAG_RSTAGE="buyer";
    public static final String TAG_RSTATUS="ar";
    public static final String TAG_LOA="loa";
    public static final String TAG_F92="f92";
    public static final String TAG_INV="inv";
    public static final String TAG_PAY="pay";
    public static final String TAG_WP="wp";

    //list total all complete sites
    public static final String URL_LIST_ALL_COMPLETE="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_combutton.php";
    public static final String TAG_JSON_ALL="Listcompbutton";
    public static final String TAG_COMPLETESITE="site";
    public static final String TAG_COMPLETEMIGDATE="migdate";
    public static final String TAG_COMPLETEEXCHANGE="exchange";
    public static final String TAG_COMPLETEBUYER="buyer";
    public static final String TAG_COMPLETEDATE="comdate";


    //list payment
    public static final String URL_LIST_VENDORPAY="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_payment.php";
    public static final String TAG_JSON_VENDOR_PAYMENT="listpaybyvendor";
    public static final String TAG_VENDORS="buyer";
    public static final String TAG_PAYMENT="paymentrec";
    public static final String TAG_SITEZ="Total Vendor";


    //profile vendor
    public static final String URL_LIST_VENDOR="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_vendor.php";
    public static final String TAG_JSON_VENDOR="listvendor";
    public static final String TAG_VENDOR="buyer";
    public static final String TAG_SITEVENDOR="Total Vendor";
    public static final String z="paymentrec";

    //list details vendor
    public static final String URL_LIST_DETAIL="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_paydetail.php";
    public static final String TAG_DETAILVENDOR="site";
    public static final String TAG_DETAILEX="exchange";
    public static final String TAG_DETAILTYPE="exchangetype";
    public static final String TAG_DETAILINV="invoice";
    public static final String TAG_DETAILSTATUS="status";

    //IPMSAN SITES
    public static final String URL_IPMSAN="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom/totalcab.php";
    public static final String URL_IPMSANBlocklist="http://58.27.84.166/mcconline/MCC%20Online%20V3/decom/totalcablist_blocked.php";
    public static final String URL_IPMSANBlocklist_perstate = "http://58.27.84.166/mcconline/MCC%20Online%20V3/decom/totalcablist_blocked_perstate.php";
    //payment outstanding
    public static final String URL_OUTSTANDING= "http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_outstanding.php";

    //list all outstanding
    public static final String URL_ALLSTANDING= "http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_listoutstanding.php";
    public static final String BUYER="BUYER";
    public static final String LOCKIN="Lock In Sales";
    public static final String PAYMENT="Payment Received";
    public static final String OUTSTANDING="Outstanding Payment";

    //list all lock-in
    public static final String URL_ALLLOCK= "http://58.27.84.166/mcconline/MCC%20Online%20V3/decom_pstn_listoutstanding.php";
    public static final String BUYERS="buyer";
    public static final String LOCKINS="Payment Received";


}
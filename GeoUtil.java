public class GeoUtil{
    
    public static Set<String> listRange(String range){
        Integer first = integer.valueof(range.split('-')[0]);
        Integer last = integer.valueof(range.split('-')[1]);
        Set<String> rangeList = new Set<String>();
        for (Integer x = first; x <= last; x ++){
            String y = String.valueof(x);
            if (y.length() < (range.split('-')[0]).length()){
                y = '0' + y;
                rangeList.add(y);
            }
            else{
                rangeList.add(y);
            }
        }
        return rangeList;
    }
                 

    public static String getState(String zipcode){
        String zip = zipcode.substring(0,5);
        if (listRange('039-049').contains(zip.substring(0,3)){
            return 'ME';
		}
        else if (listRange('030-038').contains(zip.substring(0,3)){
            return 'NH';
		}
		else if (zip.substring(0,2) == '05'){
            return 'VT';
		}
		else if (listRange('010-027').contains(zip.substring(0,3)){
            return 'MA';
		}
		else if (listRange('028-029').contains(zip.substring(0,3)){
            return 'RI';
		}
		else if (zip.substring(0,2) == '06'){
			return 'CT';
		}
		else if (listRange('10-14').contains(zip.substring(0,2) || zip.substring(0,3) == '005'){
            return 'NY';
		}		 
		else if (listRange('07-08').contains(zip.substring(0,2)){
            return 'NJ';
		}
		else if (listRange('150-196').contains(zip.substring(0,3)){
            return 'PA';
		}
		else if (listRange('197-199').contains(zip.substring(0,3)){
            return 'DE';
		}
		else if (listRange('206-219').contains(zip.substring(0,3)){
            return 'MD';
		}
		else if (zip.substring(0,3) == '200' || zip.substring(0,3) == '569'){
			return 'DC';
		}
		else if (listRange('247-269').contains(zip.substring(0,3)){
			return 'WV';
		}
		else if (listRange('220-246').contains(zip.substring(0,3) || zip.substring(0,3) ==  '201'){
			return 'VA';
		}
		else if (zip.substring(0,2) == '29'){
			return 'SC';
		}
		else if (listRange('27-28').contains(zip.substring(0,2)){
			return 'NC';
		}		 
		else if (listRange('30-31').contains(zip.substring(0,2) || listRange('398-399').contains(zip.substring(0,3)){
			return 'GA';
		}
		else if (listRange('35-36').contains(zip.substring(0,2)){
			return 'AL';
		}
		else if (listRange('32-34').contains(zip.substring(0,2)){
			return 'MS';
		}
		else if (listRange('370-385').contains(zip.substring(0,3)){
			return 'TN';
		}
		else if (listRange('40-42').contains(zip.substring(0,2)){
			return 'KY';
		}
		else if (listRange('43-45').contains(zip.substring(0,2)){
			return 'OH';
		}
		else if (listRange('46-47').contains(zip.substring(0,2)){
			return 'IN';
		}
		else if (listRange('48-49').contains(zip.substring(0,2)){
			return 'MI';
		}
		else if (listRange('60-62').contains(zip.substring(0,2)){
			return 'IL';
		}
		else if (listRange('53-54').contains(zip.substring(0,2)){
			return 'WI';
		}
		else if (listRange('550-567').contains(zip.substring(0,3)){
			return 'MN';
		}
		else if (listRange('50-52').contains(zip.substring(0,2)){
			return 'IA';
		}
		else if (listRange('63-65').contains(zip.substring(0,2)){
			return 'MO';
		}
		else if (listRange('716-729').contains(zip.substring(0,3)){
			return 'AR';
		}
		else if (listRange('700-715').contains(zip.substring(0,3)){
			return 'LA';
		}
		else if (listRange('75-79').contains(zip.substring(0,2) || zip.substring(0,3) == '885'){
			return 'TX';
		}
		else if (listRange('73-74').contains(zip.substring(0,2)){
			return 'OK';
		}
		else if (listRange('66-67').contains(zip.substring(0,2)){
			return 'KA';
		}
		else if (listRange('68-69').contains(zip.substring(0,2)){
			return 'NE';
		}
		else if (contains(zip.substring(0,2) == '57'){
			return 'SD';
		}
		else if (contains(zip.substring(0,2) == '58'){
			return 'ND';
		}
		else if (contains(zip.substring(0,2) == '59'){
			return 'MT';
		}
		else if (listRange('820-831').contains(zip.substring(0,3)){
			return 'WY';
		}
		else if (listRange('80-81').contains(zip.substring(0,2)){
			return 'CO';
		}
		else if (listRange('870-884').contains(zip.substring(0,3)){
			return 'NM';
		}
		else if (contains(zip.substring(0,2) == '84'){
			return 'UT';
		}
		else if (listRange('85-86').contains(zip.substring(0,2)){
			return 'AZ';
		}
		else if (listRange('832-839').contains(zip.substring(0,3)){
			return 'ID';
		}
		else if (listRange('980-994').contains(zip.substring(0,3)){
			return 'WA';
		}
		else if (contains(zip.substring(0,2) == '97'){
			return 'OR';
		}
		else if (listRange('889-899').contains(zip.substring(0,3)){
			return 'NV';
		}
		else if (listRange('900-961').contains(zip.substring(0,3){
			return 'CA';
		}
		else if (listRange('995-999').contains(zip.substring(0,3)){
			return 'AK';
		}
		else if (listRange('967-968').contains(zip.substring(0,3)){
			return 'HI';
		}
		else if (listRange('006-009').contains(zip.substring(0,3)){
			return 'PR';
		}
	}
	
	public static String getInferredCountry(Lead lead){
		String c = lead.mkto2__Inferred_Country__c
		Map<String, String> m = new Map<String,String>{'United States' => 'USA' ,'Canada' => 'CAN' ,'Germany' => 'DEU' ,'United Kingdom' => 'GBR' ,'France' => 'FRA' ,'Afghanistan' => 'AFG' ,'Aland Islands' => 'ALA' ,'Albania' => 'ALB' ,'Algeria' => 'DZA' ,'American Samoa' => 'ASM' ,'Andorra' => 'AND' ,'Angola' => 'AGO' ,'Anguilla' => 'AIA' ,'Antarctica' => 'ATA' ,'Antigua and Barbuda' => 'ATG' ,'Argentina' => 'ARG' ,'Armenia' => 'ARM' ,'Aruba' => 'ABW' ,'Australia' => 'AUS' ,'Austria' => 'AUT' ,'Azerbaijan' => 'AZE' ,'Bahamas' => 'BHS' ,'Bahrain' => 'BHR' ,'Bangladesh' => 'BGD' ,'Barbados' => 'BRB' ,'Belarus' => 'BLR' ,'Belgium' => 'BEL' ,'Belize' => 'BLZ' ,'Benin' => 'BEN' ,'Bermuda' => 'BMU' ,'Bhutan' => 'BTN' ,'Bolivia' => 'BOL' ,'Bosnia and Herzegovina' => 'BIH' ,'Botswana' => 'BWA' ,'Bouvet Island' => 'BVT' ,'Brazil' => 'BRA' ,'British Indian Ocean Territory' => 'IOT' ,'Brunei Darussalam' => 'BRN' ,'Bulgaria' => 'BGR' ,'Burkina Faso' => 'BFA' ,'Burundi' => 'BDI' ,'Cambodia' => 'KHM' ,'Cameroon' => 'CMR' ,'Cape Verde' => 'CPV' ,'Cayman Islands' => 'CYM' ,'Central African Republic' => 'CAF' ,'Chad' => 'TCD' ,'Chile' => 'CHL' ,'China' => 'CHN' ,'Christmas Island' => 'CXR' ,'Cocos (Keeling) Islands' => 'CCK' ,'Colombia' => 'COL' ,'Comoros' => 'COM' ,'Congo, the Democratic Republic of the' => 'COD' ,'Congo' => 'COG' ,'Cook Islands' => 'COK' ,'Costa Rica' => 'CRI' ,'Croatia' => 'HRV' ,'Cuba' => 'CUB' ,'Cyprus' => 'CYP' ,'Czech Republic' => 'CZE' ,'Cote d\'Ivoire' => 'CIV' ,'Denmark' => 'DNK' ,'Djibouti' => 'DJI' ,'Dominica' => 'DMA' ,'Dominican Republic' => 'DOM' ,'Ecuador' => 'ECU' ,'Egypt' => 'EGY' ,'El Salvador' => 'SLV' ,'Equatorial Guinea' => 'GNQ' ,'Eritrea' => 'ERI' ,'Estonia' => 'EST' ,'Ethiopia' => 'ETH' ,'Falkland Islands (Malvinas)' => 'FLK' ,'Faroe Islands' => 'FRO' ,'Fiji' => 'FJI' ,'Finland' => 'FIN' ,'French Guiana' => 'GUF' ,'French Polynesia' => 'PYF' ,'French Southern Territories' => 'ATF' ,'Gabon' => 'GAB' ,'Gambia' => 'GMB' ,'Georgia' => 'GEO' ,'Ghana' => 'GHA' ,'Gibraltar' => 'GIB' ,'Greece' => 'GRC' ,'Greenland' => 'GRL' ,'Grenada' => 'GRD' ,'Guadeloupe' => 'GLP' ,'Guam' => 'GUM' ,'Guatemala' => 'GTM' ,'Guernsey' => 'GGY' ,'Guinea-Bissau' => 'GNB' ,'Guinea' => 'GIN' ,'Guyana' => 'GUY' ,'Haiti' => 'HTI' ,'Heard Island and McDonald Islands' => 'HMD' ,'Holy See (Vatican City State)' => 'VAT' ,'Honduras' => 'HND' ,'Hong Kong' => 'HKG' ,'Hungary' => 'HUN' ,'Iceland' => 'ISL' ,'India' => 'IND' ,'Indonesia' => 'IDN' ,'Iran, Islamic Republic of' => 'IRN' ,'Iraq' => 'IRQ' ,'Ireland' => 'IRL' ,'Isle of Man' => 'IMN' ,'Israel' => 'ISR' ,'Italy' => 'ITA' ,'Jamaica' => 'JAM' ,'Japan' => 'JPN' ,'Jersey' => 'JEY' ,'Jordan' => 'JOR' ,'Kazakhstan' => 'KAZ' ,'Kenya' => 'KEN' ,'Kiribati' => 'KIR' ,'Korea, Democratic People\'s Republic of' => 'PRK' ,'Korea, Republic of' => 'KOR' ,'Kuwait' => 'KWT' ,'Kyrgyzstan' => 'KGZ' ,'Lao People\'s Democratic Republic' => 'LAO' ,'Latvia' => 'LVA' ,'Lebanon' => 'LBN' ,'Lesotho' => 'LSO' ,'Liberia' => 'LBR' ,'Libyan Arab Jamahiriya' => 'LBY' ,'Liechtenstein' => 'LIE' ,'Lithuania' => 'LTU' ,'Luxembourg' => 'LUX' ,'Macao' => 'MAC' ,'Macedonia, the former Yugoslav Republic of' => 'MKD' ,'Madagascar' => 'MDG' ,'Malawi' => 'MWI' ,'Malaysia' => 'MYS' ,'Maldives' => 'MDV' ,'Mali' => 'MLI' ,'Malta' => 'MLT' ,'Marshall Islands' => 'MHL' ,'Martinique' => 'MTQ' ,'Mauritania' => 'MRT' ,'Mauritius' => 'MUS' ,'Mayotte' => 'MYT' ,'Mexico' => 'MEX' ,'Micronesia, Federated States of' => 'FSM' ,'Moldova, Republic of' => 'MDA' ,'Monaco' => 'MCO' ,'Mongolia' => 'MNG' ,'Montenegro' => 'MNE' ,'Montserrat' => 'MSR' ,'Morocco' => 'MAR' ,'Mozambique' => 'MOZ' ,'Myanmar' => 'MMR' ,'Namibia' => 'NAM' ,'Nauru' => 'NRU' ,'Nepal' => 'NPL' ,'Netherlands Antilles' => 'ANT' ,'Netherlands' => 'NLD' ,'New Caledonia' => 'NCL' ,'New Zealand' => 'NZL' ,'Nicaragua' => 'NIC' ,'Niger' => 'NER' ,'Nigeria' => 'NGA' ,'Niue' => 'NIU' ,'Norfolk Island' => 'NFK' ,'Northern Mariana Islands' => 'MNP' ,'Norway' => 'NOR' ,'Oman' => 'OMN' ,'Pakistan' => 'PAK' ,'Palau' => 'PLW' ,'Palestinian Territory' => 'PSE' ,'Panama' => 'PAN' ,'Papua New Guinea' => 'PNG' ,'Paraguay' => 'PRY' ,'Peru' => 'PER' ,'Philippines' => 'PHL' ,'Pitcairn' => 'PCN' ,'Poland' => 'POL' ,'Portugal' => 'PRT' ,'Puerto Rico' => 'PRI' ,'Qatar' => 'QAT' ,'Romania' => 'ROU' ,'Russian Federation' => 'RUS' ,'Rwanda' => 'RWA' ,'Reunion' => 'REU' ,'Saint Barthelemy' => 'BLM' ,'Saint Helena, Ascension and Tristan da Cunha' => 'SHN' ,'Saint Kitts and Nevis' => 'KNA' ,'Saint Lucia' => 'LCA' ,'Saint Martin (French part)' => 'MAF' ,'Saint Pierre and Miquelon' => 'SPM' ,'Saint Vincent and the Grenadines' => 'VCT' ,'Samoa' => 'WSM' ,'San Marino' => 'SMR' ,'Sao Tome and Principe' => 'STP' ,'Saudi Arabia' => 'SAU' ,'Senegal' => 'SEN' ,'Serbia' => 'SRB' ,'Seychelles' => 'SYC' ,'Sierra Leone' => 'SLE' ,'Singapore' => 'SGP' ,'Slovakia' => 'SVK' ,'Slovenia' => 'SVN' ,'Solomon Islands' => 'SLB' ,'Somalia' => 'SOM' ,'South Africa' => 'ZAF' ,'South Georgia and the South Sandwich Islands' => 'SGS' ,'Spain' => 'ESP' ,'Sri Lanka' => 'LKA' ,'Sudan' => 'SDN' ,'Suriname' => 'SUR' ,'Svalbard and Jan Mayen' => 'SJM' ,'Swaziland' => 'SWZ' ,'Sweden' => 'SWE' ,'Switzerland' => 'CHE' ,'Syrian Arab Republic' => 'SYR' ,'Taiwan' => 'TWN' ,'Tajikistan' => 'TJK' ,'Tanzania, United Republic of' => 'TZA' ,'Thailand' => 'THA' ,'Timor-Leste' => 'TLS' ,'Togo' => 'TGO' ,'Tokelau' => 'TKL' ,'Tonga' => 'TON' ,'Trinidad and Tobago' => 'TTO' ,'Tunisia' => 'TUN' ,'Turkey' => 'TUR' ,'Turkmenistan' => 'TKM' ,'Turks and Caicos Islands' => 'TCA' ,'Tuvalu' => 'TUV' ,'Uganda' => 'UGA' ,'Ukraine' => 'UKR' ,'United Arab Emirates' => 'ARE' ,'United States Minor Outlying Islands' => 'UMI' ,'Uruguay' => 'URY' ,'Uzbekistan' => 'UZB' ,'Vanuatu' => 'VUT' ,'Venezuela' => 'VEN' ,'Vietnam' => 'VNM' ,'Virgin Islands, British' => 'VGB' ,'Virgin Islands, U.S.' => 'VIR' ,'Wallis and Futuna' => 'WLF' ,'Western Sahara' => 'ESH' ,'Yemen' => 'YEM' ,'Zambia' => 'ZMB' ,'Zimbabwe' => 'ZWE'};
		return m.get(c);
	}
			
    public static String getProvince(String pc){
    }

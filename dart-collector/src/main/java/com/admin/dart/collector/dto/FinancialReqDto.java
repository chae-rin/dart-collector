package com.admin.dart.collector.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 회사 재무정보 요청 정보
 */
@Getter
@Setter
public class FinancialReqDto {
        
    private String crtfc_key;	// API 인증키
    private String corp_code;	// 공시대상회사의 고유번호
    private String bsns_year;	// 사업연도
    private String reprt_code; 	// 보고서 코드 : 11013(1분기보고서), 110123(반기보고서), 11014(분기보고서), 11011(사업보고서)
    private String fs_div;		// 개별/연겳구분 : OFS(재무제표), CFS(연결재무제표)

}

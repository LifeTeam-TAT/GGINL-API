package org.tat.gginl.api.dto.billcollectionDTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BillCollectionPaymentResponseDTO {

	private String policyNo;
	private String receiptNo;

}

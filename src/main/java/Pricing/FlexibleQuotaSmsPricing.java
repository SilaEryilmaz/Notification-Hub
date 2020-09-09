package Pricing;

import Model.BillDTO;
import Model.CompanyDTO;

public class FlexibleQuotaSmsPricing implements IPackagePricing {

    public void feeCalculation(BillDTO billDTO) {

            billDTO.setBillFee(billDTO.getBillFee() + 30);
            if(billDTO.getPayingCompany().getFlexibleQuotaSmsCount()>2000) {
                billDTO.setBillFee(billDTO.getBillFee() + ((billDTO.getPayingCompany().getFlexibleQuotaSmsCount()- 2000) * 0.10));
            }
    }
}

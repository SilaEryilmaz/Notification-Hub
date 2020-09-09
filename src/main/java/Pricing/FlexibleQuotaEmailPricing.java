package Pricing;

import Model.BillDTO;
import Model.CompanyDTO;

public class FlexibleQuotaEmailPricing implements IPackagePricing {


    public void feeCalculation(BillDTO billDTO) {

        billDTO.setBillFee(billDTO.getBillFee() + 7.5);
        if(billDTO.getPayingCompany().getFlexibleQuotaSmsCount()>2000) {
            billDTO.setBillFee(billDTO.getBillFee() + ((billDTO.getPayingCompany().getFlexibleQuotaSmsCount()- 2000) * 0.03));
        }
    }
}

package Service;

import Model.BillDTO;
import Model.CompanyDTO;
import Model.NotificationDTO;
import Pricing.IPackagePricing;
import SenderMethods.IPackage;

import java.util.List;

public class PricingService {


    private List<IPackagePricing> packageFees;

    public PricingService(List<IPackagePricing> packageFees) {
        this.packageFees = packageFees;
    }

    public void feeCalculation(BillDTO billDTO) {
        for (IPackagePricing ipackage : packageFees) {
            ipackage.feeCalculation(billDTO);

        }
        billDTO.getPayingCompany().setFixedQuotaEmailCount(0);
       billDTO.getPayingCompany().setFixedQuotaSmsCount(0);
        billDTO.getPayingCompany().setFlexibleQuotaEmailCount(0);
        billDTO.getPayingCompany().setFlexibleQuotaSmsCount(0);
    }
}

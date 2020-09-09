package Model;

import Model.CompanyDTO;

import java.util.List;

public class BlacklistDTO {

    private List<CompanyDTO> companyBlackList;


    public List<CompanyDTO> getCompanyBlackList() {
        return companyBlackList;
    }

    public void setCompanyBlackList(List<CompanyDTO> companyBlackList) {
        this.companyBlackList = companyBlackList;
    }

    public void addToBlackList(BillDTO billDTO){

        if(billDTO.getAllFees().size()==2){
            companyBlackList.add(billDTO.getPayingCompany());
        }
    }
}

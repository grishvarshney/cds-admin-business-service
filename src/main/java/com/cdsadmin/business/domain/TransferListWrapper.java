package com.cdsadmin.business.domain;

import java.util.List;

public class TransferListWrapper {
    List<TransferWrapper> transferList;

    public List<TransferWrapper> getTransferList() {
        return transferList;
    }

    public void setTransferList(List<TransferWrapper> transferList) {
        this.transferList = transferList;
    }
}

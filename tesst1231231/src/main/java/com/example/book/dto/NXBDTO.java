package com.example.book.dto;

import com.example.book.entity.NXB;
import lombok.Data;

@Data
public class NXBDTO {
    private Long maNXB;
    private String tenNXB;
    private String address;
    private String SDT;
    public NXBDTO(NXB nxb) {
        this.maNXB= nxb.getMaNXB();
        this.tenNXB= nxb.getTenNXB();
        this.address=nxb.getAddress();
        this.SDT=nxb.getSDT();
    }
    public NXB toEntity() {
        NXB nxb = new NXB();
        if (this.maNXB != null) { // must has id to update
            nxb.setMaNXB(this.maNXB);
        }
        nxb.setTenNXB(this.tenNXB);
        nxb.setAddress(this.address);
        nxb.setSDT(this.SDT);
        return nxb;
    }
}

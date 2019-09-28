package com.aitekteam.developer.labourer.Models;

import java.io.Serializable;

public class PageContentModel implements Serializable {
    private int icon, value;
    private String label, satuan;

    public PageContentModel() {
    }

    public PageContentModel(int icon, int value, String label, String satuan) {
        this.icon = icon;
        this.value = value;
        this.label = label;
        this.satuan = satuan;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
}

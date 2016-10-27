package com.gaopengjie.vince.mybmob.bean;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by assistant on 2016/10/26.
 */
public class User extends BmobUser{
    private BmobFile icon;

    public BmobFile getIcon() {
        return icon;
    }

    public void setIcon(BmobFile icon) {
        this.icon = icon;
    }
}

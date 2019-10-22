package com.test.demo.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variation {

@SerializedName("name")
@Expose
public String name;
@SerializedName("price")
@Expose
public int price;
@SerializedName("default")
@Expose
public int _default;
@SerializedName("id")
@Expose
public String id;
@SerializedName("inStock")
@Expose
public int inStock;
@SerializedName("isVeg")
@Expose
public int isVeg;

}
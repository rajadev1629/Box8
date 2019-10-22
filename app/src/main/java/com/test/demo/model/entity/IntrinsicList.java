package com.test.demo.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IntrinsicList {

@SerializedName("group_id")
@Expose
public String groupId;
@SerializedName("variation_id")
@Expose
public String variationId;
@SerializedName("intrinsic_group_id")
@Expose
public String intrinsicGroupId;
@SerializedName("intrinsic_variation_id")
@Expose
public String intrinsicVariationId;

}
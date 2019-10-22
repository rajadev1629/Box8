package com.test.demo.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Variants {

@SerializedName("variant_groups")
@Expose
public List<VariantGroup> variantGroups = null;
@SerializedName("exclude_list")
@Expose
public List<List<ExcludeList>> excludeList = null;
@SerializedName("intrinsic_list")
@Expose
public List<IntrinsicList> intrinsicList = null;

}
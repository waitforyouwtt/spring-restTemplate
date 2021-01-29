package com.yidiandian;


import lombok.Data;

import java.io.Serializable;

@Data

public class BaseEntity implements Serializable {


	private String optCode;


	private String optBy;
}

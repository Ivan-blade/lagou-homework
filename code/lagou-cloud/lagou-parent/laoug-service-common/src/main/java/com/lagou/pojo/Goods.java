package com.lagou.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "goods")
public class Goods {

  @Id
  private long id;
  private String name;
  private String type;
  private long price;
  private long num;
  private String flag;

}

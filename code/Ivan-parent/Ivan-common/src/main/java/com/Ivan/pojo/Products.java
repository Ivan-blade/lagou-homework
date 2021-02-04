package com.Ivan.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "lagou",type = "products")
public class Products {

  @TableId(type = IdType.AUTO)
  private long id;

  @Field(type = FieldType.Text,analyzer = "ik_max_word")
  private String name;

  @Field(type = FieldType.Keyword)
  private double price;

  @Field(type = FieldType.Keyword)
  private String flag;

  @Field(type = FieldType.Text,analyzer = "ik_max_word")
  private String goodsDesc;

  @Field(type = FieldType.Keyword,index = false)
  private String images;

  @Field(type = FieldType.Keyword)
  private long goodsStock;

  @Field(type = FieldType.Keyword)
  private String goodsType;

}

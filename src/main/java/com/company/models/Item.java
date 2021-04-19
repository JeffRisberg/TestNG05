package com.company.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
  protected Long id;
  protected String name;
  protected String description;
  protected int price;
}

package com.xworkz.book.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RegisterDTO {

    private Integer bookId;
    private  String bookName;
    private  String bookAuthor;
}

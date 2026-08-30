package com.xworkz.book.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "book_info")
@NamedQuery( name = "getallregisterentity", query = "select r from RegisterEntity r" )
@NamedQuery( name = "getregisterbybookname", query = "select r from RegisterEntity r where r.bookName = :bookName" )
@NamedQuery( name = "getregisterbybookauthor", query = "select r from RegisterEntity r where r.bookAuthor = :bookAuthor" )
@NamedQuery( name = "getregisterbybookid", query = "select r from RegisterEntity r where r.bookId = :bookId" )
@NamedQuery( name = "getregisterbybooknameandauthor", query = "select r from RegisterEntity r where r.bookName = :bookName and r.bookAuthor = :bookAuthor" )
@NamedQuery( name = "getregisterbybookidgreaterthan", query = "select r from RegisterEntity r where r.bookId > :bookId" )
@NamedQuery( name = "getregisterbybookidlessthan", query = "select r from RegisterEntity r where r.bookId < :bookId" )
@NamedQuery( name = "getregisterbyauthorandbookid", query = "select r from RegisterEntity r where r.bookAuthor = :bookAuthor and r.bookId = :bookId" )
public class RegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;


}
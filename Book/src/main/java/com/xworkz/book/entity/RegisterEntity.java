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
@NamedQueries({

        @NamedQuery(name = "getallregisterentity", query = "select r from RegisterEntity r"),

        @NamedQuery(name = "getregisterbybookname", query = "select r from RegisterEntity r where r.bookName = :bookName"),

        @NamedQuery(name = "getregisterbybookauthor", query = "select r from RegisterEntity r where r.bookAuthor = :bookAuthor"),

        @NamedQuery(name = "getregisterbybooknameandauthor", query = "select r from RegisterEntity r where r.bookName = :bookName and r.bookAuthor = :bookAuthor"),

        @NamedQuery(name = "getregisterbyauthororbookid", query = "select r from RegisterEntity r where r.bookAuthor = :bookAuthor or r.bookId = :bookId"),

        @NamedQuery(name = "updatebooknamebyid", query = "update RegisterEntity r set r.bookName = :bookName where r.bookId = :bookId"),

        @NamedQuery(name = "updatebookauthorbyid", query = "update RegisterEntity r set r.bookAuthor = :bookAuthor where r.bookId = :bookId"),

        @NamedQuery(name = "updatebookauthorbynameandbookid", query = "update RegisterEntity r set r.bookAuthor = :bookAuthor where r.bookName = :bookName and r.bookId = :bookId"),

        @NamedQuery(name = "deleteregisterbybookid", query = "delete from RegisterEntity r where r.bookId = :bookId"),

        @NamedQuery(name = "deleteregisterbyauthororbookname", query = "delete from RegisterEntity r where r.bookAuthor = :bookAuthor or r.bookName = :bookName")

})
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
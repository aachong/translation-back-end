package com.example.translate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;

    //翻译前后语言
    private String fromLanguage;
    private String toLanguage;

    //需求，需求内容
    private String demand;
    private String demandContent;

    //单词输，价格
    private int numberWord;
    private int cost;

//    翻译内容
    @Column(columnDefinition = "TEXT")
    private String query;
    @Column(columnDefinition = "TEXT")
    private String translation;

    //0未完成，1已完成
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserInformation userInformation;
    @ManyToOne(fetch = FetchType.LAZY)
    private Translator translator;
}

package com.lime.framework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DefaultTableRow {
    protected int rn;
    protected String regUser;
    protected String regUserNm;
    protected String modUser;
    protected String modUserNm;
    protected LocalDateTime regDate;
    protected LocalDateTime modDate;
    protected int useYn;
    protected String memo;

    public DefaultTableRow(String regUser, String modUser, int useYn) {
        this.regUser = regUser;
        this.modUser = modUser;
        this.useYn = useYn;
    }

}

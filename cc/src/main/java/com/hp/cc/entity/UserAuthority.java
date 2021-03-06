package com.hp.cc.entity;

import com.hp.cc.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2019-07-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UserAuthority对象", description="")
public class UserAuthority extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long authorityId;


}

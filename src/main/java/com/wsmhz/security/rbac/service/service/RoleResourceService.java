package com.wsmhz.security.rbac.service.service;

import com.wsmhz.common.business.service.BaseService;
import com.wsmhz.security.rbac.service.domain.entity.RoleResource;

import java.util.List;

/**
 * create by tangbj on 2018/4/27
 */
public interface RoleResourceService extends BaseService<RoleResource> {
    Integer insertBatch(Long roleId, String resourceIds);

    List<Long> getAllResourceIdsByRoleId(Long roleId);
}

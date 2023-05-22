CREATE TABLE t_user
(
    id          BIGINT      Not NULL COMMENT '主键',
    create_time DATETIME    NOT NULL COMMENT '创建时间',
    update_time DATETIME    NULL COMMENT '更新时间',
    name        VARCHAR(30) NULL COMMENT '姓名',
    gender      VARCHAR(30) NOT NULL COMMENT '性别',
    is_deleted  TINYINT     NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    CONSTRAINT pk_t_todo
        PRIMARY KEY (id)
);

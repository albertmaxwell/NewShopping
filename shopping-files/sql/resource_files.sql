CREATE TABLE `file_upload` (
`id`  varchar(32) NOT NULL ,
`url`  varchar(255) NULL COMMENT '文件路径' ,
`channel`  varchar(50) NULL COMMENT '渠道' ,
`create_time`  datetime NULL COMMENT '创建时间' ,
`sync`  int(1) NULL COMMENT '文件是否已同步 0未同步 1已同步' ,
PRIMARY KEY (`id`)
)
COMMENT='文件上传记录'
;
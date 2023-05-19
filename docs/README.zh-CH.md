# 最佳实践

这个仓库用来演示工作中的最佳实践，包括：

- Restful 风格的后端响应；

## Restful 风格的后端响应

1. 通过 HTTP 状态码来区分响应的大类；
2. 通过 Response 中 Body 的 code 字段来区分业务定义错误和服务内部错误；
3. code != 200，则解析 message 展示错误信息；
4. code == 200，则解析 data 字段，获取响应数据；

```mermaid
---
title: 流程图
---
flowchart TB
Start[/开始/]
HttpCode{Http 状态码 == 200?}
	Start --> HttpCode
HttpError[Http 响应码错误]
	HttpCode -->|No| HttpError
Stop[/结束/]
	HttpError --> Stop
HttpOk[Http 响应码 200]
	HttpCode --> |Yes| HttpOk
HttpOk --> RespCode
RespCode{Resp 响应码 == 200?}
RespError[Resp Code 错误]
	RespCode -->|No| RespError
RespOk[Resp 响应码 200]
	RespCode --> |Yes| RespOk
RespData[解析 Resp Data]
	RespOk --> RespData
    RespData --> Stop
RespMsg[解析 Resp Msg]
	RespError --> RespMsg
    RespMsg --> Stop
```


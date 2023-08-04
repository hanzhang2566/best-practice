# best-practice

<a href="./docs/README.zh-CH.md">中文文档</a>

This repo demonstrates the best practice in own work， including:

- backend response in restful style;

## Backend Response in Restful Style

1. distinguish http status;
2. distinguish response body code;
3. response body code != 200, extract response body message to show;
4. response body code == 200, extract response body data to render;

```mermaid
---
title: flowchart
---
flowchart TB
Start[/Start/]
HttpCode{HttpCode == 200?}
	Start --> HttpCode
HttpError[HttpError]
	HttpCode -->|No| HttpError
Stop[/Stop/]
	HttpError --> Stop
HttpOk[HttpOk 200]
	HttpCode --> |Yes| HttpOk
HttpOk --> RespCode
RespCode{RespCode == 200?}
RespError[RespError]
	RespCode -->|No| RespError
RespOk[RespOk 200]
	RespCode --> |Yes| RespOk
RespData[extract Resp Data]
	RespOk --> RespData
    RespData --> Stop
RespMsg[extract Resp Msg]
	RespError --> RespMsg
    RespMsg --> Stop
```

## Bean Validation

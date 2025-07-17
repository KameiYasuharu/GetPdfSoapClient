package com.example.apigateway.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.apigateway.webservice.GetPdfRequest;
import com.example.apigateway.webservice.GetPdfResponse;

/**
 * PDF取得処理を行うRESTコントローラークラス
 * 
 * <p>クライアントからのリクエストを受け付け、PDF取得サービスを呼び出します。</p>
 */
@RestController // (1) RESTコントローラーとして登録（@Controller + @ResponseBody）
@RequestMapping // ベースURLマッピング
public class GetPdfSoapClientController {

	// SOAP通信を行うためのテンプレート
	private final WebServiceTemplate webServiceTemplate;

	/**
	 * コンストラクタ
	 * @param webServiceTemplate Spring WSのWebサービステンプレート
	 */
	public GetPdfSoapClientController(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
	}

	/**
	 * PDF取得APIエンドポイント
	 * 
	 * <p>GETリクエストで受け取ったPDFを返します。</p>
	 * 
	 * @return 
	 * @return PDF取得を含むレスポンス
	 * @throws IOException 
	 */
	@GetMapping("/getPdf") // (2) /getPdfパスへのGETリクエストを処理
	@ResponseBody // 戻り値を直接レスポンスボディとして返却
	public GetPdfResponse getPdfSoapClient() throws IOException {

		return (GetPdfResponse) webServiceTemplate.marshalSendAndReceive(new GetPdfRequest());

	}
}
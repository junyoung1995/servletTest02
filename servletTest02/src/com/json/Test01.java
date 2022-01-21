package com.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test01 {
	public static void main(String[] args) {
		String jsonStr = 
				"{\"id\":\"evt_1KGBx1GG19GQA0KmX7wRBJ98\","
				+ "\"object\":\"event\","
				+ "\"api_version\":\"2018-11-08\","
				+ "\"created\":1641775291,"
				+ "\"data\":{"
					+ "\"object\":{"
						+ "\"id\":\"in_1KGB0FGG19GQA0KmNapMMvec\","
						+ "\"object\":\"invoice\","
						+ "\"account_country\":\"US\","
						+ "\"account_name\":\"IrisID Systems, Inc.\","
						+ "\"account_tax_ids\":null,"
						+ "\"amount_due\":300,"
						+ "\"amount_paid\":300,"
						+ "\"amount_remaining\":0,"
						+ "\"application_fee\":null,"
						+ "\"attempt_count\":1,"
						+ "\"attempted\":true,"
						+ "\"auto_advance\":false,"
						+ "\"automatic_tax\":{"
							+ "\"enabled\":false,"
							+ "\"status\":null"
						+ "},"
						+ "\"billing\":\"charge_automatically\","
						+ "\"billing_reason\":\"subscription_cycle\","
						+ "\"charge\":\"ch_3KGBwyGG19GQA0Km1uqkk33n\","
						+ "\"collection_method\":\"charge_automatically\","
						+ "\"created\":1641771647,"
						+ "\"currency\":\"usd\","
						+ "\"custom_fields\":null,"
						+ "\"customer\":\"cus_HnW1YTzRQTjflQ\","
						+ "\"customer_address\":null,"
						+ "\"customer_email\":null,"
						+ "\"customer_name\":null,"
						+ "\"customer_phone\":null,"
						+ "\"customer_shipping\":null,"
						+ "\"customer_tax_exempt\":\"none\","
						+ "\"customer_tax_ids\":[],"
						+ "\"date\":1641771647,"
						+ "\"default_payment_method\":null,"
						+ "\"default_source\":null,"
						+ "\"default_tax_rates\":[],"
						+ "\"description\":null,"
						+ "\"discount\":null,"
						+ "\"discounts\":[],"
						+ "\"due_date\":null,"
						+ "\"ending_balance\":0,"
						+ "\"finalized_at\":1641775288,"
						+ "\"footer\":null,"
						+ "\"hosted_invoice_url\":\"https://invoice.stripe.com/i/acct_16dOGGGG19GQA0Km/live_YWNjdF8xNmRPR0dHRzE5R1FBMEttLF9LdzM2emZWOWlKeEljWFp4ZHR6SGhDcEo2SmlpV1NB0100JE9EsT3D\","
						+ "\"invoice_pdf\":\"https://pay.stripe.com/invoice/acct_16dOGGGG19GQA0Km/live_YWNjdF8xNmRPR0dHRzE5R1FBMEttLF9LdzM2emZWOWlKeEljWFp4ZHR6SGhDcEo2SmlpV1NB0100JE9EsT3D/pdf\","
						+ "\"last_finalization_error\":null,"
						+ "\"lines\":{"
							+ "\"object\":\"list\","
							+ "\"data\":[{"
								+ "\"id\":\"sli_1d9d7fGG19GQA0Km9f66a791\","
								+ "\"object\":\"line_item\","
								+ "\"amount\":300,"
								+ "\"currency\":\"usd\","
								+ "\"description\":\"1 × DoorCam Cloud Plan (at $3.00 / month)\","
								+ "\"discount_amounts\":[],"
								+ "\"discountable\":true,"
								+ "\"discounts\":[],"
								+ "\"livemode\":true,"
								+ "\"metadata\":{"
									+ "\"cam_id\":\"138669\","
									+ "\"service_type\":\"doorcam\""
									+ "},"
								+ "\"period\":{"
									+ "\"end\":1644450027,"
									+ "\"start\":1641771627"
								+ "},"
								+ "\"plan\":{"
									+ "\"id\":\"doorcam-cloud-plan\","
									+ "\"object\":\"plan\","
									+ "\"active\":true,"
									+ "\"aggregate_usage\":null,"
									+ "\"amount\":300,"
									+ "\"amount_decimal\":\"300\","
									+ "\"billing_scheme\":\"per_unit\","
									+ "\"created\":1511940402,"
									+ "\"currency\":\"usd\","
									+ "\"interval\":\"month\","
									+ "\"interval_count\":1,"
									+ "\"livemode\":true,"
									+ "\"metadata\":{},"
									+ "\"nickname\":null,"
									+ "\"product\":\"prod_Br8EpueR1IJ2NF\","
									+ "\"tiers\":null,"
									+ "\"tiers_mode\":null,"
									+ "\"transform_usage\":null,"
									+ "\"trial_period_days\":null,"
									+ "\"usage_type\":\"licensed\""
									+ "},"
								+ "\"price\":{"
									+ "\"id\":\"doorcam-cloud-plan\","
									+ "\"object\":\"price\","
									+ "\"active\":true,"
									+ "\"billing_scheme\":\"per_unit\","
									+ "\"created\":1511940402,"
									+ "\"currency\":\"usd\","
									+ "\"livemode\":true,"
									+ "\"lookup_key\":null,"
									+ "\"metadata\":{},"
									+ "\"nickname\":null,"
									+ "\"product\":\"prod_Br8EpueR1IJ2NF\","
									+ "\"recurring\":{"
										+ "\"aggregate_usage\":null,"
										+ "\"interval\":\"month\","
										+ "\"interval_count\":1,"
										+ "\"trial_period_days\":null,"
										+ "\"usage_type\":\"licensed\""
										+ "},"
									+ "\"tax_behavior\":\"unspecified\","
									+ "\"tiers_mode\":null,"
									+ "\"transform_quantity\":null,"
									+ "\"type\":\"recurring\","
									+ "\"unit_amount\":300,"
									+ "\"unit_amount_decimal\":\"300\""
									+ "},"
								+ "\"proration\":false,"
								+ "\"quantity\":1,"
								+ "\"subscription\":\"sub_HntCESE8Co8fwS\","
								+ "\"subscription_item\":\"si_HntCz4ADRJXD3X\","
								+ "\"tax_amounts\":[],"
								+ "\"tax_rates\":[],"
								+ "\"type\":\"subscription\","
								+ "\"unique_id\":\"il_1KGB0FGG19GQA0Km8y8Gp0GW\""
							+ "}],"
							+ "\"has_more\":false,"
							+ "\"total_count\":1,"
							+ "\"url\":\"/v1/invoices/in_1KGB0FGG19GQA0KmNapMMvec/lines\""
						+ "},"
						+ "\"livemode\":true,"
						+ "\"metadata\":{},"
						+ "\"next_payment_attempt\":null,"
						+ "\"number\":\"A87447E5-0019\","
						+ "\"on_behalf_of\":null,"
						+ "\"paid\":true,"
						+ "\"payment_intent\":\"pi_3KGBwyGG19GQA0Km1Pvpv22G\","
						+ "\"payment_settings\":{"
							+ "\"payment_method_options\":null,"
							+ "\"payment_method_types\":null"
						+ "},"
						+ "\"period_end\":1641771627,"
						+ "\"period_start\":1639093227,"
						+ "\"post_payment_credit_notes_amount\":0,"
						+ "\"pre_payment_credit_notes_amount\":0,"
						+ "\"quote\":null,"
						+ "\"receipt_number\":null,"
						+ "\"starting_balance\":0,"
						+ "\"statement_descriptor\":null,"
						+ "\"status\":\"paid\","
						+ "\"status_transitions\":{"
							+ "\"finalized_at\":1641775288,"
							+ "\"marked_uncollectible_at\":null,"
							+ "\"paid_at\":1641775288,"
							+ "\"voided_at\":null"
						+ "},"
						+ "\"subscription\":\"sub_HntCESE8Co8fwS\","
						+ "\"subtotal\":300,"
						+ "\"tax\":null,"
						+ "\"tax_percent\":null,"
						+ "\"total\":300,"
						+ "\"total_discount_amounts\":[],"
						+ "\"total_tax_amounts\":[],"
						+ "\"transfer_data\":null,"
						+ "\"webhooks_delivered_at\":1641771648"
					+ "}},"
					+ "\"livemode\":true,"
					+ "\"pending_webhooks\":3,"
					+ "\"request\":{"
						+ "\"id\":null,"
						+ "\"idempotency_key\":null"
					+ "},"
					+ "\"type\":\"invoice.payment_succeeded\""
				+ "}";		
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;
		try {
			jsonObj = (JSONObject)parser.parse(jsonStr);
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		//{camid, cloud plan, customer, period_end, period_start, description} 찾기
		//System.out.println(jsonObj);
		JSONObject data = (JSONObject)jsonObj.get("data");
		JSONObject object = (JSONObject)data.get("object");
		JSONObject lines = (JSONObject)object.get("lines");
		JSONArray linesData = (JSONArray)lines.get("data");
		JSONObject arrData = (JSONObject)linesData.get(0);
		JSONObject plan = (JSONObject)arrData.get("plan");
		JSONObject metadata = (JSONObject)arrData.get("metadata");
		JSONObject period = (JSONObject)arrData.get("period");

		/*
		 * System.out.println(metadata.get("cam_id"));
		 * System.out.println(plan.get("id");
		 * System.out.println(object.get("customer"));
		 * System.out.println(period.get("start"));
		 * System.out.println(period.get("end"));
		 * System.out.println(arrData.get("description"));
		 */
		
		JSONObject jsonOutput = new JSONObject();
		jsonOutput.put("camid", metadata.get("cam_id"));
		jsonOutput.put("Cloud Plan", plan.get("id"));
		jsonOutput.put("customer", object.get("customer"));
		jsonOutput.put("period_start", period.get("start"));
		jsonOutput.put("period_end", period.get("end"));
		jsonOutput.put("description", arrData.get("description"));
		System.out.println(jsonOutput);
		String str = jsonOutput.toJSONString();
		System.out.println(str);
		
		//여기서부터는 webhook.site를 이용한 데이터 전송
		try {
			String host_url = "https://webhook.site/029729c8-e052-4aba-aa79-80b40f122e52";
			HttpURLConnection conn = null;
			
			URL url = new URL(host_url);
			conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("POST"); //POST방식으로 전송
			conn.setRequestProperty("Content-Type", "application/json");
			
			//POST방식으로 스트링을 통한 JSON 전송
			conn.setDoOutput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			
			bw.write(str);
			bw.flush();
			bw.close();
			
			//서버에서 보낸 응답 데이터 수신 받기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String returnMsg = br.readLine();
			System.out.println("응답 메세지: " + returnMsg);
			
			//Http 응답코드 수신
			int responseCode = conn.getResponseCode();
			if(responseCode == 400) {
				System.out.println("Error 400 명령 실행 오류");
			}
			else if(responseCode == 500){
				System.out.println("Error 500 서버 에러");
			}
			else {//정상 실행 시 code = 200
				System.out.println("응답코드: " + responseCode);
			}
		}catch(IOException e){
			System.out.println("IOException " + e.getCause());
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Exceotion " + e.getCause());
			e.printStackTrace();
		}
	}
}

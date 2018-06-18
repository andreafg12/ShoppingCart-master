package com.sahan.zaizi.controller;

public class ShoppingCartController {

	public static void main(String[] args) {

		String requestContentAsString = "------WebKitFormBoundaryZ8HCBzhVWbUANtKM"+"\n"+
				"Content-Disposition: form-data; name='descripcion'"+"\n\n"+"bhvbc"+"\n"+"------WebKitFormBoundaryZ8HCBzhVWbUANtKM"
				+"\n"+"Content-Disposition: form-data; name='tipoRelacion'"+"\n\n"+"CLIENTE"+"\n"+"------WebKitFormBoundaryZ8HCBzhVWbUANtKM"+
				"\n"+"Content-Disposition: form-data; name='uploadfile'; filename='diagrama.pdf'"+"\n"+"Content-Type: application/pdf"+"\n\n"+
				"%PDF-1.7";
		int endOfHeaderIndex = 0, beginOfHeaderIndex = 0;
		String line, name = "tipoRelacion", tipo = "value";
		while (endOfHeaderIndex < requestContentAsString.length() && beginOfHeaderIndex > -1 && endOfHeaderIndex > -1) {
			beginOfHeaderIndex = requestContentAsString.indexOf("------WebKitFormBoundaryZ8HCBzhVWbUANtKM", beginOfHeaderIndex);
			endOfHeaderIndex = requestContentAsString.indexOf("\n\n", beginOfHeaderIndex);
			line = requestContentAsString.substring(beginOfHeaderIndex, endOfHeaderIndex);
			System.out.println(beginOfHeaderIndex+".."+endOfHeaderIndex+line);
			if(line.contains(name)) {
				if("value".equalsIgnoreCase(tipo)) {
					//Obtiene el valor del campo
					System.out.println(requestContentAsString.indexOf("------WebKitFormBoundaryZ8HCBzhVWbUANtKM", endOfHeaderIndex));
					line = requestContentAsString.substring(endOfHeaderIndex, requestContentAsString.indexOf("------WebKitFormBoundaryZ8HCBzhVWbUANtKM", endOfHeaderIndex));
				}
				System.out.println(line);
				break;
			}
			beginOfHeaderIndex = endOfHeaderIndex + 1;
		}
	}

}

package com.lucasoliveira.uploadlog.api.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasoliveira.uploadlog.api.entity.Log;
import com.lucasoliveira.uploadlog.api.repository.LogRepository;
import com.lucasoliveira.uploadlog.api.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService{
	
	@Autowired
	private LogRepository repository;
	

	@Override
	public void upload() {
		
		
		String linha = null;
		 
	      try {
	         FileReader reader = new FileReader("/Users/lucasoliveira/access.log"); // Localização do Arquivo
	         BufferedReader leitor = new BufferedReader(reader);
	         StringTokenizer st = null;
	          
	         String date;         // Armazena campo de numero
	         String ip;
	         String request;
	         String status;
	         String userAgent;
	         

	 
	         while ((linha = leitor.readLine()) != null) {
	                                           
	             
	            // UTILIZA DELIMITADOR ; PARA DIVIDIR OS CAMPOS
	            st = new StringTokenizer(linha, "|");
	            String dados = null;
	 
	            while (st.hasMoreTokens()) {
	 
	               // Campo Data
	               dados = st.nextToken();
	               date = dados;
	               
	               
	               // Campo ip
	               dados = st.nextToken();
	               ip = dados;
	               

	               // Campo request
	               dados = st.nextToken();
	               request = dados;
	               
	               // Campo status
	               dados = st.nextToken();
	               status = dados;
	               
	               // Campo user agent
	               dados = st.nextToken();
	               userAgent = dados;
	               
	               
	               Log log = new Log(date, ip, request, status, userAgent);
	               repository.save(log);


	            }
	         }
	         leitor.close();
	         reader.close();
	 
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	}

}

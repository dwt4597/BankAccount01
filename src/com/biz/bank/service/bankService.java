package com.biz.bank.service;

import java.io.*;
import java.util.*;

import com.biz.bank.VO.*;

public class bankService {
	List<bankVO> bankList;
	String bangbang;
	Scanner scanner = new Scanner(System.in);

	public bankService(String bangbang) {
		bankList = new ArrayList();
		this.bangbang = bangbang;

	}

	public void lanni() {
		while (true) {
			System.out.print("입금/출금/종료 입력 >>>");
			String s = scanner.nextLine();
			System.out.print("계좌번호 입력 >>>");
			String ss = scanner.nextLine();

			for (bankVO vo : bankList) {
				if (s.equals("입금") && ss.equals(vo.getStrnum())) {
					System.out.println("입금액 적어>>>");
					int ipgemac = scanner.nextInt();
					int a = vo.getIntdon() + ipgemac;
					System.out.println("총잔액:" + a);
					vo.setIntdon(a);
					continue;
				} else if (s.equals("출금") && ss.equals(vo.getStrnum())) {
					System.out.println("출금액 적어>>>");
					int chulgemac = scanner.nextInt();
					int c = vo.getIntdon();
					if (chulgemac < c) {
						c = c - chulgemac;
						System.out.println(c);
						vo.setIntdon(c);
					} else if (chulgemac > c) {
						System.out.println("잔액부족");
						continue;
					}

				}
			}

		}

	}

	public void spliter(String bangbang) {
		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(bangbang);
			buffer = new BufferedReader(fr);
			while (true) {
				bankVO vo = new bankVO();
				String line = buffer.readLine();
				if (line == null)
					break;
				String[] lines = line.split(":");

				vo.setStrnum(lines[0]);
				vo.setIntdon(Integer.valueOf(lines[1]));
				vo.setDay(lines[2]);
				bankList.add(vo);
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

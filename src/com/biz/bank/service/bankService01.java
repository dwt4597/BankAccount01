package com.biz.bank.service;

import java.io.*;
import java.util.*;

import com.biz.bank.VO.*;

public class bankService01 {
	List<bankVO> bankList;
	String bangbang;
	Scanner scanner = new Scanner(System.in);

	public bankService01(String bangbang) {
		bankList = new ArrayList();
		this.bangbang = bangbang;

	}

	public void lanni() {
		int isum = 0;
		int zsum = 0;
		boolean sw = true;
		while (true) {
			System.out.print("입금/출금/종료 입력 >>>");
			String s = scanner.nextLine();

			if (s.equals("입금")) {
				System.out.print("계좌번호 입력 >>>");
				String stra = scanner.nextLine();
				int ss = Integer.valueOf(stra);
				System.out.println("입금액 입력>>>");
				String strb = scanner.nextLine();
				int indon = Integer.valueOf(strb);
				int ipTotal = 0;

				for (bankVO vo : bankList) {
					if (ss == Integer.valueOf(vo.getStrnum())) {
						ipTotal = indon + vo.getIntdon();
						System.out.println("총잔액:" + ipTotal);

						vo.setIntdon(ipTotal);

					}

				}

			}
			if (s.equals("출금")) {
				System.out.print("계좌번호 입력 >>>");
				String strc = scanner.nextLine();
				int ss = Integer.valueOf(strc);
				System.out.println("출금액 입력>>>");
				String strd = scanner.nextLine();
				int chuldon = Integer.valueOf(strd);
				
				for (bankVO vo : bankList) {
					int chulTotal = 0;
					if (ss == Integer.valueOf(vo.getStrnum())) {
						if (chuldon < vo.getIntdon()) {
							chulTotal = vo.getIntdon() - chuldon;
							System.out.println("총잔액:" + chulTotal);

							vo.setIntdon(chulTotal);
						} else if (chuldon > vo.getIntdon()) {
							System.out.println("잔액부족");
							continue;
						}

					}
				}
			}

			if (s.equals("종료")) {
				System.out.println("종료합니다~");
				break;
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

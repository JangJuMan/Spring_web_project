package com.project.omeran.service;

import com.project.omeran.dto.UserVO;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

//import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.omeran.dao.MemberDAO;
import com.project.omeran.dto.MallVO;
import com.project.omeran.dto.MemberVO;

@Service("memberService") // 이 객체의 이름을 memberService라고지정, 다른 곳에서 memberServic이라는 bean사용할수 있도록
public class MemberServiceImpl implements MemberService{
	@Autowired // 의존성 주입 즉 MemberDAO 객체를 여기서 사용할 수 있게끔 해줌
    MemberDAO memberDao;

    
    @Override
    public String getEmail(String id) {
        return memberDao.getEmail(id);
    }
    
    @Override
    public boolean loginCheck(UserVO vo, String id, String pw, HttpSession session) {
    	Map<String, String> userInfo = memberDao.getUserInfo(id,  pw);
    	if(userInfo != null) {
    		System.out.println("Login INfo: "+userInfo);
    		
    		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		
    		int u_id = userInfo.get("u_id") != null ? (int)Integer.parseInt(String.valueOf(userInfo.get("u_id"))) : 0;
    		String user_id = userInfo.get("user_id") != null ? userInfo.get("user_id") : "";
    		String password = userInfo.get("password") != null ? userInfo.get("password") : "";
    		String user_name = userInfo.get("user_name") != null ? userInfo.get("user_name") : "";
    		String grade = userInfo.get("grade") != null ? userInfo.get("grade") : "";
    		String telephone = userInfo.get("password") != null ? userInfo.get("telephone") : "";
    		int gender = userInfo.get("gender") != null ? (int)Integer.parseInt(String.valueOf(userInfo.get("gender"))) : 0;
    		String email = userInfo.get("email") != null ? userInfo.get("email") : "";
    		int is_sms = userInfo.get("is_sms") != null ? (int)Integer.parseInt(String.valueOf(userInfo.get("is_sms"))) : 0;
    		int is_email = userInfo.get("is_email") != null ? (int)Integer.parseInt(String.valueOf(userInfo.get("is_email"))) : 0;
    		String user_memo = userInfo.get("user_memo") != null ? userInfo.get("user_memo") : "";
    		String signin_date = userInfo.get("signin_date") != null ? formatter.format(userInfo.get("signin_date")) : "2020-01-01 00:00:00";
    		String modify_date = userInfo.get("modify_date") != null ? formatter.format(userInfo.get("modify_date")) : "2020-01-01 00:00:00";
    		int user_category = userInfo.get("user_category") != null ? (int)Integer.parseInt(String.valueOf(userInfo.get("user_category"))) : 0;
    		String recommander_id = userInfo.get("recommander_id") != null ? userInfo.get("recommander_id") : "";
    		int mall_id = userInfo.get("mall_id") != null ? (int)Integer.parseInt(String.valueOf(userInfo.get("mall_id"))) : 0;
    		String mall_name = userInfo.get("mall_name") != null ? userInfo.get("mall_name") : "";
    		boolean loginValidity = true;
    		
    		vo.setU_id(u_id);
    		vo.setUser_id(user_id);
    		vo.setPassword(password);
    		vo.setUser_name(user_name);
    		vo.setGrade(grade);
    		vo.setTelephone(telephone);
    		vo.setGender(gender);
    		vo.setEmail(email);
    		vo.setIs_sms(is_sms);
    		vo.setIs_email(is_email);
    		vo.setUser_memo(user_memo);
    		vo.setSignin_date(signin_date);
    		vo.setModify_date(modify_date);
    		vo.setUser_category(user_category);
    		vo.setRecommander_id(recommander_id);
    		vo.setMall_id(mall_id);
    		vo.setMall_name(mall_name);
    		vo.setLoginValidity(loginValidity);
    		
    		// System.out.println("userVO toString : "+vo.toString());
    		
    		// 세션 변수 등록 
    		session.setAttribute("u_id", vo.getU_id());
    		session.setAttribute("user_id", vo.getUser_id());
    		// session.setAttribute("password", vo.getPassword());
    		session.setAttribute("user_name", vo.getUser_name());
    		session.setAttribute("grade", vo.getGrade());
    		session.setAttribute("telephone", vo.getTelephone());
    		session.setAttribute("gender", vo.getGender());
    		session.setAttribute("email", vo.getEmail());
    		session.setAttribute("is_sms", vo.getIs_sms());
    		session.setAttribute("is_email", vo.getIs_email());
    		// session.setAttribute("user_memo", vo.getUser_memo());
    		session.setAttribute("signin_date", vo.getSignin_date());
    		session.setAttribute("modify_date", vo.getModify_date());
    		session.setAttribute("user_category", vo.getUser_category());
    		session.setAttribute("recommander_id", vo.getRecommander_id());
    		session.setAttribute("mall_id", vo.getMall_id());
    		session.setAttribute("loginValidity", vo.isLoginValidity());
    		
    		//TODO: 관리하는 사이트 정보 가져와서 세션에 저장하기
    		session.setAttribute("adminSiteName", vo.getMall_name());
    		
    		return true;
    	}
    	else {
    		return false;
    	}
    }

	@Override
	public void logout(HttpSession session, UserVO vo) {
		vo.setLoginValidity(false);
		session.setAttribute("loginValidity", false);
		session.setAttribute("user_name", null);
		session.invalidate();
	}
	

	@Override 
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception { 
		return memberDao.selectBoardList(map);
	}
	
	@Override  // 게시글 입력 
	public void insertBoard(Map<String, Object> map) throws Exception { 
		//nt u_id = (int)session.getAttribute("u_id");
		memberDao.insertBoard(map); 
	}
	
	@Override //게시글 수정
	public void updateBoard(Map<String, Object> map) throws Exception{
		memberDao.updateBoard(map); 
	}


	@Override
	public int getFaqCount(String keyword) {
		return memberDao.getFaqCount(keyword);
	}


	@Override
	public List<Map<String, Object>> getFaqList(int startIndex, int cntPerPage, String keyword) {
		return memberDao.getFaqList(startIndex, cntPerPage, keyword);
	}

	@Override
	public void deleteFaq(int faq_id) {
		memberDao.deleteFaqBoard(faq_id);
	}

	@Override
	public void updateFaq(Map<String, Object> map) {
		memberDao.updateFaqBoard(map);
		
	}
	
	// 쇼핑몰 상품 관련
	@Override
	public int mall_getProductCount(String keyword) {
		return memberDao.mall_getProductCount(keyword);
	}
	
	@Override
	public List<Map<String, Object>> mall_getProductList(int startIndex, int cntPerPage, String keyword) {
		return memberDao.mall_getProductList(startIndex, cntPerPage, keyword);
	}

	@Override
	public Map<String, Object> mall_getProductDetail(int p_id) {
		// TODO Auto-generated method stub
		return memberDao.mall_getProductDetail(p_id);
	}
	
	//회원가입 관련
	@Override
	public void insertUserInfo(UserVO userVO) throws Exception {
//		System.out.println(userVO.getEmail());
		memberDao.insertUserInfo(userVO);
	}
	@Override
	public int idCheck(UserVO userVO) throws Exception {
		return memberDao.idCheck(userVO);
	}
	

	
	// Admin
	// 상품관리 
	@Override
	public int admin_getSiteCountBySiteName(String siteName) {
		return memberDao.getSiteCountBySiteName(siteName);
	}
	
	@Override
	public List<Map<String, Object>> getAllProductList(HttpSession session) {
		return memberDao.getAllProductList((int)session.getAttribute("mall_id"));
	}

	@Override
	public List<Map<String, Object>> getProductList(String state_id, HttpSession session) {
		System.out.println("MALL ID: "+session.getAttribute("mall_id"));
		return memberDao.getProductList(state_id, (int)session.getAttribute("mall_id"));
	}

	@Override
	public List<Map<String, Object>> getStateList(String category) {
		return memberDao.getStateList(category);
	}

	@Override
	public void productSimpleUpdate(int productId, int price, int discount_price, String stateId) {
		memberDao.productSimpleUpdate(productId, price, discount_price, stateId);
	}

	@Override
	public void productDelete(int productId) {
		memberDao.productDelete(productId);
	}

	@Override
	public void adminProductCreateNew(Map<String, String> paramMap) {
		memberDao.adminProductCreateNew(paramMap);
	}

	@Override
	public Map<String, Object> admin_getProductInfoById(int p_id) {
		return memberDao.admin_getProductInfoById(p_id);
	}

	@Override
	public void adminProduct_modifyDetail(Map<String, String> paramMap) {
		System.out.println(paramMap);
		memberDao.adminProduct_modifyDetail(paramMap);
	}

	
	// Super Admin
	@Override
	public int superAdmin_getMallCount(Map<String, String> paramMap) {
		return memberDao.superAdmin_getMallCount(paramMap);
	}

	@Override
	public List<MallVO> superAdmin_getMalls(Map<String, String> paramMap) {
		return memberDao.superAdmin_getMalls(paramMap);
	}

	@Override
	public void superAdminMain_simpleDelete(int mall_id) {
		memberDao.superAdminMain_simpleDelete(mall_id);
	}

	@Override
	public void superAdmin_createNewMall(Map<String, String> paramMap) {
		memberDao.superAdmin_createNewMall(paramMap);
	}

	@Override
	public List<Map<String, Object>> superAdmin_getAllMalls_name_id() {
		return memberDao.superAdmin_getAllMalls_name_id();
	}

	@Override
	public void superAdmin_createNewAdmin(Map<String, String> paramMap) {
		memberDao.superAdmin_createNewAdmin(paramMap);
	}

	@Override
	public Map<String, Object> superAdmin_getMallInfoById(int mall_id) {
		return memberDao.superAdmin_getMallInfoById(mall_id);
	}

	@Override
	public void superAdmin_modifyMall(Map<String, String> paramMap) {
		memberDao.superAdmin_modifyMallDetail(paramMap);
	}

	@Override
	public int superAdmin_getAdminCount(Map<String, String> paramMap) {
		return memberDao.superAdmin_getAdminCount(paramMap);
	}

	@Override
	public List<UserVO> superAdmin_getAdminList(Map<String, String> paramMap) {
		return memberDao.superAdmin_getAdminList(paramMap);
	}

	@Override
	public Map<String, Object> superAdmin_getUserInfoById(int u_id) {
		return memberDao.superAdmin_getUserInfoById(u_id);
	}

	@Override
	public void superAdmin_modifyDetailAdmin_withoutPW(Map<String, String> paramMap) {
		memberDao.superAdmin_modifyDetailAdmin_withoutPW(paramMap);
	}
	
	@Override
	public void superAdmin_modifyDetailAdmin_withPW(Map<String, String> paramMap) {
		memberDao.superAdmin_modifyDetailAdmin_withPW(paramMap);
	}

	@Override
	public void superAdmin_manager_simpleDelete(int u_id) {
		memberDao.superAdmin_manager_simpleDelete(u_id);
	}

	@Override
	public void superAdmin_manager_simpleModify(Map<String, String> paramMap) {
		memberDao.superAdmin_manager_simpleModify(paramMap);
	}

	@Override
	public int superAdmin_getCustomerCount(Map<String, String> paramMap) {
		return memberDao.superAdmin_getCustomerCount(paramMap);
	}

	@Override
	public List<UserVO> superAdmin_getCustomerList(Map<String, String> paramMap) {
		return memberDao.superAdmin_getCustomerList(paramMap);
	}

	@Override
	public void superAdmin_customer_simpleDelete(int u_id) {
		memberDao.superAdmin_customer_simpleDelete(u_id);
	}

	@Override
	public void superAdmin_customer_simpleModify(Map<String, String> paramMap) {
		memberDao.superAdmin_customer_simpleModify(paramMap);
	}

	@Override
	public int mallNameCheck(MallVO mallVO) {
		return memberDao.superAdmin_mallNameCheck(mallVO);
	}
}

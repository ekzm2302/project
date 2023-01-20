<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head>
<style>
select {
	width: 200px;
}
</style>
</head>

<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<!-- 경로를 나타내주는 부분입니다 해당하는 내용을 작성해주세요 -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">

			<div class="d-flex justify-content-between align-items-center">
				<h2>정보수정</h2>
				<ol>
					<li><a href="<c:url value='/'/>">홈</a></li>
					<li>관리자</li>
					<li>사원관리</li>
					<li>정보수정</li>
				</ol>
			</div>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title text-center" style="font-weight: bold;">정보수정</h3>
						</div>
						<form action="update.emp" method="post" id="update">
							<div class="card-body">
								<div class="card-title mb-4">
									<div class="d-flex justify-content-start"
										style="column-gap: 2rem;">
										<div class="image-container">
											<img
												src="${vo.profile_path ne null ? vo.profile_path : 'assets/img/user_profile.png'}"
												id="imgProfile" style="width: 150px; height: 150px"
												class="img-thumbnail" />

										</div>
										<div class="userData align-self-center">
											<h2 class="d-block"
												style="font-size: 1.5rem; font-weight: bold">
												${vo.emp_name }</h2>
										<h6 class="d-block">${vo.branch_name } ${vo.department_name }</h6>
										<h6 class="d-block">${vo.rank_name }</h6>
										</div>
										<div class="ml-auto">
											<input type="button" class="btn btn-primary d-none"
												id="btnDiscard" value="Discard Changes" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-12">
										<ul class="nav nav-tabs mb-4" id="myTab" role="tablist">
											<li class="nav-item"><a class="nav-link active"
												id="basicInfo-tab" data-toggle="tab" href="#basicInfo"
												role="tab" aria-controls="basicInfo" aria-selected="true">정보</a>
											</li>

										</ul>
										<div class="tab-content ml-1" id="myTabContent">
											<div class="tab-pane fade show active" id="basicInfo"
												role="tabpanel" aria-labelledby="basicInfo-tab">


												<div class="row">
													<div class="col-sm-3 col-md-2 col-5">
														<label style="font-weight: bold;">사번</label>

													</div>
													<div class="col-md-8 col-6">${vo.emp_no }
														<input type="hidden" name="emp_no" value="${vo.emp_no}" />
													</div>
												</div>
												<hr />

												<div class="row">
													<div class="col-sm-3 col-md-2 col-5">
														<label style="font-weight: bold;">성명</label>
													</div>
													<div class="col-md-8 col-6">
														<input type="text" name="emp_name" value="${vo.emp_name}" />
													</div>
												</div>
												<hr />
												<div class="row">
													<div class="col-sm-3 col-md-2 col-5">
														<label style="font-weight: bold;">생년월일</label>
													</div>
													<div class="col-md-8 col-6">
														<input type="date" name="birth" value="${vo.birth}" />
													</div>
												</div>
												<hr />
												<div class="row">
													<div class="col-sm-3 col-md-2 col-5">
														<label style="font-weight: bold;">성별</label>
													</div>
													<div class="col-md-8 col-6">
														<input type='radio' value='남' name='gender'
															<c:if test='${ vo.gender eq "남" }'>checked</c:if>>남&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type='radio' value='여' name='gender'
															${vo.gender eq '여' ? 'checked' : ''}>여
													</div>
												</div>
												<hr />

												<div class="row">
													<div class="col-sm-3 col-md-2 col-5">
														<label style="font-weight: bold;">전화번호</label>
													</div>
													<div class="col-md-8 col-6">
														<input type="text" name="phone" value="${vo.phone}" />
													</div>
												</div>
												<hr />
												<div class="row">
													<div class="col-sm-3 col-md-2 col-5">
														<label style="font-weight: bold;">이메일</label>
													</div>
													<div class="col-md-8 col-6">
														<input type="text" name="email" value="${vo.email}" />
													</div>
												</div>
												<hr />
												<div class="row">
													<div class="col-sm-3 col-md-2 col-5">
														<label style="font-weight: bold;">고용일</label>
													</div>
													<div class="col-md-8 col-6">
														<input type="date" name="hire_date"
															value="${vo.hire_date}" />
													</div>
												</div>
												<hr />

												<div class="row">
													<div class="col-sm-3 col-md-2 col-5">
														<label style="font-weight: bold;">지점</label>
													</div>
													<div class="col-md-8 col-6">
														<select name="branch_name" id="">
															<c:forEach var="b" items="${branches}">
																<option value="${b.code}"
																	${vo.branch_name eq b.code_value ? ' selected':''}>
																	${b.code_value}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<hr />
												<div class="row">
													<div class="col-sm-3 col-md-2 col-5">
														<label style="font-weight: bold;">부서</label>
													</div>
													<div class="col-md-8 col-6">
														<select name="department_name" id="">
															<c:forEach var="d" items="${departments}">
																<option value="${d.code}"
																	${vo.department_name eq d.code_value ? ' selected':''}>
																	${d.code_value}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<hr />
												<div class="row">
													<div class="col-sm-3 col-md-2 col-5">
														<label style="font-weight: bold;">직위</label>
													</div>
													<div class="col-md-8 col-6">
														<select name="rank_name" id="">
															<c:forEach var="r" items="${ranks}">
																<option value="${r.code}"
																	${vo.rank_name eq r.code_value ? ' selected':''}>
																	${r.code_value}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<hr />

												<c:if test="${vo.admin ne 'X0'}">
													<div class="row">
														<div class="col-sm-3 col-md-2 col-5">
															<label style="font-weight: bold;">관리자</label>

														</div>
														<div class="col-md-8 col-6">
															<input type='radio' value='L0' name='admin'
																<c:if test='${     vo.admin     eq "L0"  }'>checked</c:if>>일반&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<input type='radio' value='L1' name='admin'
																${vo.admin eq 'L1' ? 'checked' : ''}>관리자
														</div>
													</div>
													<hr />
												</c:if>
												<c:if test="${vo.admin eq 'X0'}">
													<input type="hidden" name="admin" value="X0" />
													<div class="row">
														<div class="col-sm-3 col-md-2 col-5">
															<label style="font-weight: bold;">상태</label>
														</div>
														<div class="col-md-8 col-6">퇴사자</div>
													</div>
													<hr />
												</c:if>

											</div>
											<div class="row">
												<div class="col-6"></div>
												<div class="col-6">
													<div class="mr-0">
														<button type="button" class="btn btn-secondary"
															onclick="history.go(-1)">이전으로</button>
														<button type="button" class="btn btn-primary update">확인</button>
														<button type="button" class="btn btn-danger deleteEmp">퇴사</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>


							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
		$('.update').click(function() {

			if (emptyCheck())
				$('#update').submit();
		});
		$('.deleteEmp').click(function() {
			if (confirm('[${vo.emp_name}] 님을 퇴사시키시겠습니까?')) {
				location = 'fire.emp?id=${vo.emp_no}';
			}
		});
	</script>


</main>
<!-- End #main -->

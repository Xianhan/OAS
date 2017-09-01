<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>登录</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="images/public.css" type=text/css rel=stylesheet>
<LINK href="images/login.css" type=text/css rel=stylesheet>

<STYLE type=text/css>
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
<script type="text/javascript" src="js/login.js"></script>
</HEAD>
<BODY>
	<DIV id=div1>
	<form action="Login" method="post" id="login" onsubmit="return checkAll()"><!-- 表单 -->
		<TABLE id=login height="100%" cellSpacing=0 cellPadding=0 width=800
			align=center>
			<TBODY id=main>
				<TR>
					<TD>
						<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
							<TBODY>
								<TR>
									<TD colSpan=4>&nbsp;</TD>
								</TR>
								<TR height=30>
									<TD width=380>&nbsp;</TD>
									<TD>&nbsp;</TD>
									<TD>&nbsp;</TD>
									<TD>&nbsp;</TD>
								</TR>
								<TR height=40>
									<TD rowSpan=4>&nbsp;</TD>
									<TD>工号：</TD>
									<TD><INPUT form="login" class=textbox placeholder="请输入工号" type="text" maxlength="6" id=txtUserName name="username">
									</TD>
									<TD width=120>&nbsp;</TD>
								</TR>
								<TR height=40>
									<TD>密 码：</TD>
									<TD><INPUT form="login" class=textbox placeholder="请输入密码" id=txtUserPassword type=password
										name=password></TD>
									<TD width=120>&nbsp;</TD>
								</TR>
								<TR height=40>
									<TD>验证码：</TD>
									<TD vAlign=center colSpan=2>
									<INPUT id="txt_yzm" placeholder="验证码" size=4
										name="yzm"  maxlength="4" form="login"> <span id="res"></span> <IMG src="login/image.jsp"
										border=0 form="login" id="img_yzm"> <A id="yzm" href="#">不清楚，再来一张</A></TD>
								</TR>
								<TR height=40>
									<TD></TD>
									<TD align=right><INPUT id=btnLogin type=submit  
										value=" 登 录 " name=btnLogin form="login"></TD>
									<TD width=120>&nbsp;</TD>
								</TR> 
								<TR height=90>
									<TD colSpan=4>&nbsp;</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
				</TR>
				<TR id=root height=104>
					<TD>&nbsp;</TD>
				</TR>
			</TBODY>
		</TABLE>
		</form>
	</DIV>
	<DIV id=div2 style="DISPLAY: none"></DIV>
	</CONTENTTEMPLATE>
</BODY>
</HTML>

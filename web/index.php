<HTML>
<HEAD>
<LINK REL="stylesheet" TYPE="text/css" HREF="../../style.css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Skyriser Media - Games - Video Poker - Fun Mobile Video Games</title>
</HEAD>
<BODY>
<?php 
					require('../../db_connect.php');
					$browsername = "?";
					$browsername  = $_SERVER['HTTP_USER_AGENT'];
					$registered_date = date('Y-m-d h:i:s');
					$insert = "INSERT INTO $db_tablename_poker 
						(date, ip, browser, language) 
						VALUES ('".$registered_date."','".$_SERVER['REMOTE_ADDR']."', '".$browsername."', 0)";
				
				
				$result = $db_object->query($insert);
				if(DB::isError($result)) {
					//echo $result->getMessage();
					}
?>	
<table>
<tr>
<td valign="top" width="270">

<table class="bordershadow_applet" border="0" cellspacing="0" cellpadding="0">  
																			<tr>
																				    <td class="bordershadow_applet-topLeft"></td>
																				    <td class="bordershadow_applet-top"></td>
																				    <td class="bordershadow_applet-topRight"></td>
																			</tr>
																			<tr>
																				     <td class="bordershadow_applet-left"></td>
																				     <td class="bordershadow_applet-center">
																	     
																						<APPLET code="Poker.class" archive="Poker_Applet.jar" width=240 height=160>
																						<PARAM name="cabbase" value="Poker_Applet.cab">
																						Browser is not Java enabled.
																						</applet>
																			 			</td>
																				     <td class="bordershadow_applet-right"></td>   
																			</tr>
																			<tr>
																				     <td class="bordershadow_applet-bottomLeft"></td>
																				     <td class="bordershadow_applet-bottom"></td>
																				     <td class="bordershadow_applet-bottomRight"></td>
																			</tr>
																</table>
	

</td>
<td valign="top">
<p>
<b>Video Poker</b><br>
Skyriser Media<br>
<br>
<b>Controls:</b><br>
Move: <i>Arrow Keys</i><br>
Select: <i>Space Bar</i><br>
</p>
<p align="center">
<a href="javascript:void(window.close())">Close</a>
</p>

</td>
</tr>
</table>
</BODY>
</HTML>







<HTML>
<HEAD>
<LINK REL="stylesheet" TYPE="text/css" HREF="../../style.css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Skyriser Media - Jeux - Video Poker - Jeux Vidéos Portables Amusants</title>
</HEAD>
<BODY>
<?php 
					require('../../db_connect.php');
					$browsername = "?";
					$browsername  = $_SERVER['HTTP_USER_AGENT'];
					$registered_date = date('Y-m-d h:i:s');
					$insert = "INSERT INTO $db_tablename_poker 
						(date, ip, browser, language) 
						VALUES ('".$registered_date."','".$_SERVER['REMOTE_ADDR']."', '".$browsername."', 1)";
				
				
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
																						Fureteur ne supporte pas Java.
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
<b>Controles:</b><br>
Bouger: <i>Flèches Clavier</i><br>
Selectionner: <i>Barre Espace</i><br>
</p>
<p align="center">
<a href="javascript:void(window.close())">Fermer</a>
</p>
</td>
</tr>
</table>
</BODY>
</HTML>






<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!int flag=0; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.table{
	border-style: solid;
	border-color: #0000ff;
    width: 600px;
	color: blue;
	font-family: verdana;
	font-size: 20px;
	text-align: center;
}
</style>
</head>
<body background="pattern4.jpg">
<%
	
	if(request.getSession().getAttribute("userId")==null)
	{ 
		response.sendRedirect("fail.jsp");
	}
%>

        <div>

            <h3> Choose File to Upload in Server </h3>

            <form action="./upload" method="post" enctype="multipart/form-data">

                <input type="file" name="file" />
                
                <input type="hidden" name="fno" value="2">

                <input type="submit" value="upload" />

            </form>    
            
                <form action="./logout" method="post">

                <input type="submit" value="Logout"  />

            </form>         

        </div>
        
        
     <h3>Uploaded Images</h3>
     <div class="table-responsive">          
        <table class="table" border="2">
          <col width="120">
          <col width="120">
          <col width="120">
          <col width="120">
          <col width="120">
          <thead>
           <tr>
        <th>Image Id</th>
        <th>Name</th>
        <th>Size(Bytes)</th>
        <th>Preview</th>
        <th>Actions</th>
        </tr>
       </thead>
           <%@ page import="java.util.*"
                    import="com.nagarro.fileupload.data.Image"
                    import="com.nagarro.fileupload.data.User"
                    import="org.hibernate.*"
                    import="com.nagarro.fileupload.service.HibernateUtil"
                    import="java.sql.Blob" 
                    import="java.io.*"
                    import= "org.hibernate.Session"%>
       
       <%	        Session session1 = HibernateUtil.getSessionFactory().openSession();
                         Transaction transaction = null;
                          try {
                        	   
                               transaction=session1.beginTransaction();
                               String retrieveRecords = "from Image WHERE userId=:Id";
                               Query query = session1.createQuery(retrieveRecords);
                               query.setParameter("Id", request.getSession().getAttribute("userId"));
                               Iterator<Image> it = query.iterate(); 
                               int sno;
                               while (it.hasNext()) {
                                   Image image = (Image) it.next();
                                  // java.sql.Blob blob = image.getOriginalImage();  
                           		  // InputStream in = blob.getBinaryStream();  
                           		   //BufferedImage img = ImageIO.read(in);
                           		   //ByteArrayOutputStream baos = new ByteArrayOutputStream();
                           		   //ImageIO.write( img, "jpg", baos );
                           		   //baos.flush();
                           		   //byte[] imageInByteArray = baos.toByteArray();
                           		   //baos.close();
                           		   //String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray); 
                                   

                         %>
                    <tr>
                    <td>
                           <%
                                               sno=image.getImageId();
                                               out.print("\t" + image.getImageId());
                           %>
                    </td>
                    <td>
                           <%
                                 out.print("\t" + image.getImageName());
                           %>
                    </td>
                    <td>
                           <%
                                 out.print("\t" + image.getSize() + "Bytes");
                           %>
                    </td> 
                    
                    <td><img src="ImageUpload?imageId=<%=sno%>" width="50"
                           height="50"></td>
                           

                    <td>

                           <form action="./EditDetails" method="post">

                                 Enter the new file Name:<input type="text" name="newFileName">
                                 <br> <input type="hidden" name="imgId" value="<%=sno%>">
                                 <input type="submit" value="Edit"><br>

                           </form>
                    </td>  
                    <td>
                           <form action="./DeleteRecord" method="post">
                                 <input type="submit" name="delete" value="Delete"> <input
                                        type="hidden" name="imgId" value=<%=sno%>>
                           </form>
                    </td>
                  <%
                           
                                 }
                                 transaction.commit();
                           } finally {
                                 session1.close();
                           }
                    %>

             </tr>
    
       </table>
                         
       </div>
        

       


</body>
</html>
<?php
    include_once 'Variables.php';
    
    //This query finds if the user exists
    
    // $statement = mysqli_prepare($con, "SELECT * FROM events");
    // mysqli_stmt_bind_param($statement, "sss", $title, $description, $image);
    // mysqli_stmt_execute($statement);
    
    // mysqli_stmt_store_result($statement);
    // mysqli_stmt_bind_result($statement, $userID, $title, $description, $host, $location, $noStudents, $dates, $time, $image);
    
    $query = mysqli_query($con,"SELEC * FROM events");

    if(mysqli_connect_error($con))
    {
        $response["response"] = "Server is Down!";
        echo json_encode($response);
    }

    else if($query) {

        while($row = mysqli_fetch_array($query)) {
        //This is what will be given back to the code
            $array[] = $row;

        }
    }
    echo json_encode($array);
    
    
?>
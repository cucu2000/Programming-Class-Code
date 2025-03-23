import React, {useState} from 'react';
import {Text} from "react-native";
import {useAuth0} from "react-native-auth0";
import CustomButton from "../../components/CustomButton";
import {VStack} from "@react-native-material/core";
import CustomInput from "../../components/CustomInput";
import {fetch} from "react-native/Libraries/Network/fetch";
import {useNavigation} from "@react-navigation/native";

const HomeScreen = () => {
    const [response, setResponse] = useState();
    const {clearSession, user} = useAuth0();
    const navigation = useNavigation();
    const {magicMelee, hitMiss} = useState("");

    const onLogOutPressed = async () => {
        try {
            await clearSession();
            navigation.navigate('SignIn');
        } catch (e) {
            console.log(e);
        }
    };

    const onRollChartPressed = async () => {
        try {
              console.log("loadUsers");
              fetch("https://localhost:5001/MagicMiss/25", {
                  method: "GET",
                  headers: {
                      "Content-Type": "application/json"
                  }     }).then(res => {
                      console.log(res);
                      return res.json();
                  }).then(res => {
                      console.log(res);
                let data = res.data;
                     setResponse(data);
            })
        }catch (e) {
            console.log(e);
        }
    }

    return (

      <VStack>
          {user && <Text>Logged in as {user.name}</Text>}
          {!user && <Text>Not logged in</Text>}
          <CustomInput value={magicMelee} placeHolder={"Magic or Melee"}/>
              <CustomInput value={hitMiss} placeHolder={"Hit or Miss"}/>
              <CustomButton onPress={onRollChartPressed} text={"Roll Chart"}/>
             <CustomButton onPress={onLogOutPressed} text={"Log Out"}/>

      </VStack>
    );
}

export default HomeScreen;
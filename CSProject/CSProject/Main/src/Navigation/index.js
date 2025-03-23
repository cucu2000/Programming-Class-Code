import React from 'react';
import {NavigationContainer} from "@react-navigation/native";
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import SignInScreen from '../screens/SignInScreen';
import HomeScreen from "../screens/HomeScreen";
import RollScreen from "../screens/RollScreen";

const Stack = createNativeStackNavigator();

const Navigation = () => {
    return (
        <NavigationContainer>
            <Stack.Navigator screenOptions={{headerShown: false}}>
                {/*<Stack.Screen name="SignIn" component={SignInScreen}/>*/}
                <Stack.Screen name="Home" component={HomeScreen}/>
                <Stack.Screen name="Roll" component={RollScreen}/>
            </Stack.Navigator>
        </NavigationContainer>

    );
}

export default Navigation;
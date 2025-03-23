import React from 'react';
import {View, Image, StyleSheet, useWindowDimensions, ScrollView} from 'react-native';
import Logo from '../../../assets/Logo_1.png';
import CustomButton from "../../components/CustomButton";
import {useNavigation} from "@react-navigation/native";
import {useAuth0} from "react-native-auth0";

const SignInScreen = () => {

    const {height} = useWindowDimensions();
    const navigation = useNavigation();
    const {authorize} = useAuth0();

    const onSignInPressed = async () => {
        try {
            await authorize();
            navigation.navigate('Home');
        } catch (e) {
            console.log(e);
        }
    }

    return (
        <ScrollView showsVerticalScrollIndicator={false}>
            <View style={styles.root}>
                <Image
                    source={Logo}
                    style={[styles.logo, {height: height * 0.3}]}
                    resizeMode="contain"
                />

                <CustomButton
                    text={"Sign In with Auth0"}
                    onPress={onSignInPressed}
                />

            </View>
        </ScrollView>
    )
}

const styles = StyleSheet.create({
    root: {
        alignItems: 'center',
        padding: 20,
    },

    logo: {
        width: '70%',
        mawWidth: 300,
        maxHeight: 200,
    },
});

export default SignInScreen;
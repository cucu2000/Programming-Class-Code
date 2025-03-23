import React from 'react';
import {Text, TextInput, View, StyleSheet} from "react-native";

const CustomInput = ({value, setValue, placeHolder, secureTextEntry}) => {
    return (
        <View style={styles.container}>
            <TextInput
                value={value}
                onChangeText={setValue}
                placeholder={placeHolder}
                secureTextEntry={secureTextEntry}
                style={styles.input}/>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        backgroundColor: 'white',
        width: '100%',

        borderColor: 'light-grey',
        borderWidth: 1,
        borderRadius: 5,

        paddingHorizontal: 10,
        marginVertical: 5,
    },

    input: {},
});


export default CustomInput;
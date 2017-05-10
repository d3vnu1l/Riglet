---------------- R.I.G.L.E.T ----------------
|                                           |
|            Project Lead : Gerry Patia     |
| System Backend Engineer : Imed Abdellaoui |
|       Android Team Lead : Ryan Deushane   |
|   Android Team Engineer : Lorenzo Perez   |
|        Design Team Lead : Antonius Beshay |
|    Design Team Engineer : Edgar Avalos    |
|                                           |
---------------------------------------------

Version 1.0.0 - Q2 2017
System Requirements - Device running Android Version 4.0 or later

_____________ Table of Contents _____________

1.0 Basic Program Information
    1.1 Program Introduction
    1.2 Program Design

2.0 Instructions for Use
    2.1 Signing Up / Login
        2.1.1 New Users
        2.1.2 Returning Users
        2.1.3 Password Recovery
    2.2 Adding a Friend
    2.3 Send Messages
    2.4 Friends List
        2.4.1 Edit Friend
    2.5 User Settings Page
    2.6 Navigation via Taskbar

3.0 Extended Program Details
    3.0 Current Program Functionality
    3.1 Possible Future Improvements
    3.2 Changelog

4.0 Notes & References
    4.1 Design and Implementation References
    4.2 Notes

----------------------------------------------------------------------------------------------------

_____________ 1.0 Basic Program Information _____________

    1.1 ~~~ Program Introduction ~~~
        RIGLET is an instant messaging application developed for the Android platform.
        Users of the application can use it to send messages to people that they
        have added to their friends list. Currently the application is under continued
        development with several features planned to improve the user experience.

    1.2 ~~~ Program Design ~~~
        The program is designed through an architecture designated as "MVC". This allows
        the application to have a flexible design in terms of development and functionality.
        Because feedback from users is an important aspect of our design process, it is
        necessary that the program is modular in order to accommodate improvements.


_____________ 2.0 Instructions for Use _____________

    2.1 ~~~ Signing Up / Login ~~~

        2.1.1 ~~~ New Users ~~~
        New users of the application will first have to sign up so that they can provide
        information about themselves to establish their profile. Users will need to provide
        the following personal information: first name, last name, gender
        and the following other information: password, unique id, recovery email
        the unique id and password are for future login, and the personal information is for
        identification to friends. Order to enter this information to sign up, click the sign
        up button while on the login screen. The sign up screen will be displayed, and once the
        information is entered simply click the sign up button displayed at the bottom of the
        screen and your profile will be created and stored for future use.

        2.1.2 ~~~ Returning Users ~~~
        Returning users can login by entering their unique id that they created in the signup
        process in the field next to "Unique ID" and by entering their password  in the password
        field. After making sure both entries are correct, click the login button to begin using
        the program. See section 2.1.3 if you have trouble remembering your password.

        2.1.3 ~~~ Password Recovery ~~~
        If a user has forgotten their password or unique ID, they can click on the button named
        "forgot password or unique ID" and they will be taken to the information recovery screen.
        Once there, they will be prompted to provide an email address that they entered during the
        signup process. Their unique id and password will be sent to this address.

    2.2 ~~~ Adding a Friend ~~~
        To add a friend, click on the middle button of the taskbar located at the bottom of the
        screen. This will display the "add friend" page where the user will be prompted to provide
        the unique id belonging to the friend that they wish to add. Once this has been completed,
        that friend will be accessible in the friends list as well as the chatroom.

    2.3 ~~~ Send Messages ~~~
        To send messages, first make sure you have navigated to the home screen of the application.
        This can be done by clicking on the leftmost button of the taskbar located at the bottom of
        the screen. Once at the home screen, select a user from the list to begin chatting. This
        will load the chatroom where you can start a new conversation, or view previous messages.

    2.4 ~~~ Friends List ~~~
        To access the friends list, click on the second button on the taskbar that is located at the
        bottom of the screen. This will load the friends list. Once here, a user may view all of the
        people that they have added as their friends and opt to edit these friends.

        2.4.1 ~~~ Edit Friend ~~~
        If a user wishes to edit their friend's display name (the name that appears in the chatroom
        or on the friends list) or remove their friend, they may do this by clicking on the button
        named "Edit" located directly next to the friend that they wish to edit on the friends list
        page. This will load the "edit friend" page where the user can either choose to rename or
        remove their friend.

    2.5 ~~~ User Settings Page ~~~
        If a user wishes to change their information such as first name, last name, gender, or
        password, they may do this through the settings page. This page can be accessed through the
        button located on the taskbar with the gear icon.

    2.6 ~~~ Navigation via Taskbar ~~~
        The application is designed such that the majority of the navigation throughout the program
        will be made by use of the taskbar. The intent of this is that it simplifies use of the
        application due to ease of navigation.

_____________ 3.0 Extended Program Details _____________

    3.0 ~~~ Current Program Functionality ~~~
        Currently the program is a simple instant text messaging application with friend list
        functionality. The user of the application can add friends and send text messages to them
        in a chatroom environment.

    3.1 ~~~ Possible Future Improvements ~~~
        Future improvements to the application can include improvements such as:
        - Ability to send content other than plaintext
        - Ability to message multiple friends (Groupchat)
        - Language Filtering
        - UI Improvements, including the option to select ui theme/color


    3.2 ~~~ Changelog ~~~
        After the first initial release is made, this section shall be updated with details of the
        changes made between versions.


_____________ 4.0 Notes & References _____________

        4.1 ~~~ Design and Implementation References ~~~
            The program is in development using the Android Studio IDE and Java langauge.
            Protoyping for the UI was carried out using a free account provided by www.Proto.io
            All elements utilized are open source or liscence.

        4.2 ~~~ Notes ~~~
        (This section left for user / developer notes)
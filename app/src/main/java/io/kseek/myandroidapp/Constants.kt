package io.kseek.myandroidapp

object Constants {
    fun getUsers(): ArrayList<User> {
        val userList = ArrayList<User>()

        val user1 = User(
            1, "시키", R.drawable.ic_launcher_background,
            "시키1", "시키2", "시키3", "시키4",
            1
        )

        val user2 = User(
            2, "시키", R.drawable.ic_launcher_background,
            "시키1", "시키2", "시키3", "시키4",
            2
        )

        userList.add(user1)
        userList.add(user2)

        return userList
    }
}
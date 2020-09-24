# WARNING: using this script will get rid of all messages and contacts. Use at your OWN RISK

# drops to ensure db is created successfully
DROP DATABASE scalachat;
CREATE DATABASE scalachat;

CREATE TABLE users
(
	user_id SERIAL,
	username VARCHAR(255) NOT NULL,
	PRIMARY KEY(user_id)
);

CREATE TABLE chat
(
	chat_id SERIAL NOT NULL PRIMARY KEY
);

CREATE TABLE participants
(
	chat_id SERIAL NOT NULL,
	user_id SERIAL NOT NULL,
	PRIMARY KEY (chat_id, user_id),
	CONSTRAINT fk_part_user
		FOREIGN KEY(chat_id)
			REFERENCES users(user_id),
	CONSTRAINT fk_part_chat
		FOREIGN KEY(user_id)
			REFERENCES chat(chat_id)
);

CREATE TABLE messages
(
	msg_id SERIAL NOT NULL,
	chat_id SERIAL NOT NULL,
	contents TEXT NOT NULL,
	PRIMARY KEY(msg_id, chat_id),
	CONSTRAINT fk_msg
		FOREIGN KEY(chat_id)
			REFERENCES chat(chat_id)
);

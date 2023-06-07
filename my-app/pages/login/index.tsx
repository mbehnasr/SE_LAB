"use client"; // This is a client component 👈🏽

import React from 'react';
import { Breadcrumb, Layout, Menu, theme } from 'antd';
import TimeLine from '../../components/Timeline';
const { Header, Content, Footer } = Layout;
/*new Array(3).fill(null).map((_, index) => ({
    key: String(index + 1),
    label: `nav ${index + 1}`,
}))}*/
const App: React.FC = () => {
    const {
        token: { colorBgContainer },
    } = theme.useToken();
    return (
        <Layout>
            <Header
                style={{
                    position: 'sticky',
                    top: 0,
                    zIndex: 1,
                    width: '100%',
                    display: 'flex',
                    alignItems: 'center',
                }}
            >

                <div className="demo-logo" />
                <Menu
                    theme="dark"
                    mode="horizontal"
                    defaultSelectedKeys={['2']}
                    items={
                    [
                        {key:1,label:"hello"},{key:2,label:"hello2"}
                        // {key:2,label}
                    ]
                    }


                />
            </Header>
            <TimeLine />
            <Content className="site-layout" style={{ padding: '0 50px' }}>
                <Breadcrumb style={{ margin: '16px 0' }}>
                    <Breadcrumb.Item>Home</Breadcrumb.Item>
                    <Breadcrumb.Item>List</Breadcrumb.Item>
                    <Breadcrumb.Item>App</Breadcrumb.Item>
                </Breadcrumb>
                <div style={{ padding: 24, minHeight: 380, background: colorBgContainer }}>Content</div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>Ant Design ©2023 Created by Ant UED</Footer>
        </Layout>
    );
};

export default App;